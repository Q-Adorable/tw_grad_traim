// console.log('hello world');
class Animal{
    constructor (name,legNum, color){
        this.name = name;
        this.legNum=legNum;
        this.color=color;
    }

    describe(){
        console.log('My name is',this.name,',I have ',this.legNum,'legs ,my color is', this.color);
    }
}

class Dog extends Animal{
    constructor(name,color){
        super(name,4,color);
    }
}

class Fish extends Animal{
    constructor(name,color){
        super(name,0,color);
    }

    describe(){
        super.describe();
        console.log('And I can swim');
    }
}

const wangcai=new Dog('wangcai','yellow');
const dahuang=new Dog('dahuang','yellow');
const xiaoqiang =new Animal('xiaoqiang','black');
const goldFish = new Fish('goldFish','gold')
wangcai.describe();
dahuang.describe();
xiaoqiang.describe();
goldFish.describe();