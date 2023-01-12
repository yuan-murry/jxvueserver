export default class Progress {
  constructor(option) {
    this.dpr = window.devicePixelRatio || 1
    this.dom = option.dom
    // [[颜色1,百分值], ...] 
    // this.color = option.color || [['rgba(204, 0, 0, 1.000)', 0]]
    this.color = option.color || [['rgba(238, 73, 41, 1)', 0], ['rgba(149, 236, 105, 1)', .5], ['rgba(86, 179, 255, 1)', 1]]
    // 实现方式（svg/canvas）
    // 值
    this.value = option.value || 0.75
    // 分段数
    this.num = option.num || 300
    // 是否圆角
    this.round = option.round || true
    // 动画时长(需要大于分段数)
    this.duration = (option.duration || 3000) / this.num
    if (this.duration < 0) this.duration = 1
    // 内圆半径
    this.innerRadius = (option.innerRadius || 50) * this.dpr
    // 外圆半径
    this.outerRadius = (option.outerRadius || 60) * this.dpr
    // 开始角度
    this.degree = (option.degree || 0) / 360 * 2 * Math.PI
    // 旋转方向
    this.counterclockwise = option.counterclockwise || false
    // 背景环颜色
    this.bgColor = option.bgColor || 'rgba(238, 239, 243, 1.000)'
    // 文字颜色
    this.fontColor = option.fontColor || 'rgba(58, 87, 168, 1)'
    // 文字大小
    this.fontSize = option.fontSize || 16
    // 文字后缀
    this.suffix = option.suffix || "%"
    // 小数位
    this.toFixed = option.toFixed || "1"
  }
  init() {
    if (!this.dom) return
    if (this.color.length < 1) return
    this.canvasDom = document.createElement("CANVAS")
    this.textDom = document.createElement("DIV")
    this.canvasDom.height = this.dom.offsetHeight
    this.canvasDom.width = this.dom.offsetWidth
    this.dom.appendChild(this.canvasDom)
    this.dom.appendChild(this.textDom)
    this.ctx = this.canvasDom.getContext("2d")
    this.dom.style.position = 'relative'
    this.textDom.style.position = 'absolute'
    this.textDom.style.width = '100px'
    this.textDom.style.height = '100px'
    this.textDom.style.textAlign = 'center'
    this.textDom.style.lineHeight = '100px'
    this.textDom.style.color = this.fontColor
    this.textDom.style.fontSize = this.fontSize + 'px'
    this.textDom.style.top = '0'
    this.textDom.style.left = '0'
    this.textDom.style.right = ' 0'
    this.textDom.style.bottom = ' 0'
    this.textDom.style.margin = ' auto'
    // 通过dpr来解决模糊的情况
    this.canvasDom.width = this.dom.offsetWidth * this.dpr;
    this.canvasDom.height = this.dom.offsetHeight * this.dpr;
    this.canvasDom.style.width = this.dom.offsetWidth + "px"
    this.canvasDom.style.height = this.dom.offsetHeight + "px"

    this.draw()
  }
  async draw() {
    // 背景环
    this.ctx.beginPath()
    this.ctx.arc(
      this.canvasDom.width / 2,
      this.canvasDom.height / 2,
      (this.outerRadius - this.innerRadius) / 2 + this.innerRadius,
      0,
      2 * Math.PI
    )
    this.ctx.lineWidth = this.outerRadius - this.innerRadius
    this.ctx.strokeStyle= this.bgColor
    this.ctx.stroke()

    // 如果长度为1就默认为纯色
    if (this.color.length === 1) {
      this.ctx.beginPath()
      this.ctx.arc(
        this.canvasDom.width / 2,
        this.canvasDom.height / 2,
        (this.outerRadius - this.innerRadius) / 2 + this.innerRadius,
        - Math.PI / 2 + this.degree,
        this.counterclockwise ?  
          - (Math.PI * 2 * this.value) - Math.PI / 2 + this.degree : 
          (Math.PI * 2 * this.value) - Math.PI / 2 + this.degree,
        this.counterclockwise)
      this.ctx.lineWidth = this.outerRadius - this.innerRadius
      this.ctx.lineCap = this.round ? "round" : "butt"
      this.ctx.strokeStyle= this.color[0][0]
      this.ctx.stroke()
      return
    }

    // 数组的四项分别代表rgba
    const middleColor = [[], [], [], []]
    // 把颜色的插值求出来,两个两个的求他们之间的值
    for (let i = 0; i < this.color.length - 1; i++) {
      // 获得第一个颜色的数组[r,g,b,a]
      const fromColor = this.colorToRgb(this.color[i][0]).slice(5, -1).split(',').map(item => Number(item))
      // 获得第二个颜色的数组
      const toColor = this.colorToRgb(this.color[i + 1][0]).slice(5, -1).split(',').map(item => Number(item))
      // 这两个颜色之间的渐变渲染的长度就是to - from
      const from = this.color[i][1]
      const to = this.color[i + 1][1]
      // 当前这项拆成几份
      const count = Math.round(this.num * (to - from))
      // rgba每个循环一次来求值
      fromColor.forEach((item, index) => {
        // 每一份之间的差(减去1的原因是第1份的时候i是0然后第count份的时候i是count - 1)
        const differ = (toColor[index] - item) / (count - 1)
        for(let i = 0; i < count; i++) {
          // 累加一下push到middleColor的对应的项中
          middleColor[index].push((item + differ * i).toFixed(2))
        }
      })
    }
    // 循环开始渲染数据就好每次渲染两份的距离,原因是可能每次一份之间因为计算的精确度会出现缝隙,最后一次只渲染一份就好
    for(let i = 0; i< this.num; i++) {
      this.ctx.beginPath()
      if(i === this.num - 1) 
        this.ctx.arc(
          this.canvasDom.width / 2,
          this.canvasDom.height / 2,
          (this.outerRadius - this.innerRadius) / 2 + this.innerRadius,
          this.counterclockwise ? 
            - (Math.PI * 2 * this.value) / this.num * i - Math.PI / 2 + this.degree :
            (Math.PI * 2 * this.value) / this.num * i - Math.PI / 2 + this.degree,
          this.counterclockwise ? 
            - Math.PI * 2 * this.value / this.num * (i + 1) - Math.PI / 2 + this.degree : 
            (Math.PI * 2 * this.value) / this.num * (i + 1) - Math.PI / 2 + this.degree,
          this.counterclockwise)
      else
        this.ctx.arc(
          this.canvasDom.width / 2,
          this.canvasDom.height / 2,
          (this.outerRadius - this.innerRadius) / 2 + this.innerRadius,
          this.counterclockwise ? 
            - (Math.PI * 2 * this.value) / this.num * i - Math.PI / 2 + this.degree :
            (Math.PI * 2 * this.value) / this.num * i - Math.PI / 2 + this.degree,
          this.counterclockwise ? 
            - Math.PI * 2 * this.value / this.num * (i + 2) - Math.PI / 2 + this.degree : 
            (Math.PI * 2 * this.value) / this.num * (i + 2) - Math.PI / 2 + this.degree,
          this.counterclockwise)
      this.ctx.lineWidth = this.outerRadius - this.innerRadius
      this.ctx.lineCap = this.round ? "round" : "butt"
      this.ctx.strokeStyle= `rgba(${middleColor[0][i]}, ${middleColor[1][i]}, ${middleColor[2][i]}, ${middleColor[3][i]})`
      this.ctx.stroke();
      this.textDom.innerHTML = (this.value * 100 * i / (this.num - 1)).toFixed(this.toFixed) + this.suffix
      if (this.duration !== 0) {
        if (this.duration < 7) {
          // 把1,2,3,4,5,6毫秒间隔的分别放大6,5,4,3,2,1倍,因为settimeout的最小延迟大概是5,放大的做法是间隔放大的倍数执行一次
          if (i % (6 - this.duration + 1) === 0) {
            await this.sleep(this.duration * (6 - this.duration + 1))
          }
        } else {
          await this.sleep(this.duration)
        }
      }
    }
  }
  // 把颜色都转换成rgba
  colorToRgb (color) {
    const div = document.createElement('div');
    div.style.backgroundColor = color;
    document.body.appendChild(div);
    const c = window.getComputedStyle(div).backgroundColor;    
    document.body.removeChild(div);
    const indexRgb = c.indexOf('rgb')
    if (indexRgb === -1) {
      return 'rgba(255,255,255,0)'
    }
    if (c.indexOf('rgba') === -1) {
      return 'rgba' + c.slice(0 + 3, -1) + ', 1)'
    }
    return c;
  };
  sleep(val) {
    return new Promise(resolve => {
      setTimeout(() => {
        resolve()
      }, val);
    })
  }
  setVal(val) {
    this.value = val
    this.ctx.clearRect(0, 0, this.dom.offsetWidth, this.dom.offsetHeight); 
    this.draw()
  }
  remove() {
    this.dom.removeChild(this.canvasDom)
    this.dom.removeChild(this.textDom)
  }
}