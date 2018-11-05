const Person = require('./person');

module.exports = class Teacher extends Person{
    constructor(name,age,classes){
        super(name,age);
        this.classes=classes;
    }
    introduce(){
        if(this.classes.length <= 0){
            return super.introduce()+' I am a Teacher. I teach No Class.';
        }
        return super.introduce()+' I am a Teacher. I teach Class '+this.classes[0].number+','+this.classes[1].number+'.';
    }
}