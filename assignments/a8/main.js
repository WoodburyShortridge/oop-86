let main = null;
window.onload = () => {
  // create main class
  main = new Main();
  // add stye to btns
  const buttons = document.getElementsByTagName('button');
  for (let i = 0; i < buttons.length; i++) {
    buttons[i].setAttribute("style", "background:rgba(50, 139, 255, 0.33);border:none;box-shadow: rgb(50, 139, 255) 3px 4px 0px;padding: 1rem; margin: 1rem;font-weight: 700;");
  }
}

class Main {
  constructor () {
    this.canvas = document.getElementById ("canvas");
    this.gc = this.canvas.getContext("2d");
    this.x = canvas.width/2 - 25;
    this.y = canvas.height /2 -25;
    this.w = 50;
    this.h = 50;
    this.color = "#000"
    this.draw();
  }

  draw() {
    // background
  	this.gc.fillStyle = "#000";
  	this.gc.fillRect (0, 0, canvas.width, canvas.height);
    // square
    this.gc.beginPath();
    this.gc.fillStyle = this.color;
    this.gc.fillRect(this.x,this.y,this.w,this.h);
    this.gc.strokeStyle = "#fff";
    this.gc.rect(this.x,this.y,this.w,this.h);
    this.gc.stroke();
    this.gc.closePath();
  }

  moveSquare(direction) {
    if (direction === "left") {
      this.x -= 10;
    } else if (direction === "right") {
      this.x += 10;
    }
    this.draw();
  }

  resizeSquare(size) {
    if (size === "bigger") {
      this.w += 10;
      this.h += 10;
    } else if (size === "smaller" && this.w > 0) {
      this.w -= 10;
      this.h -= 10;
    }
    this.draw();
  }

  fillSquare() {
    switch(this.color) {
        case "#000":
            this.color = "#fff"
            break;
        case "#fff":
            this.color = "#000"
            break;
        default:
            this.color = "#000"
    }
    this.draw();
  }
}
