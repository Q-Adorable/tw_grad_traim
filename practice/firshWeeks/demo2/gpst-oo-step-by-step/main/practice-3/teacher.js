const Person = require('./person');

module.exports = class Teacher extends Person{
    constructor(name,age,clazzes){
        super(name,age);
        this.clazzes=clazzes;
    }

    introduce(){
        if(this.clazzes.length === 0){
            return super.introduce()+' I am a Teacher. I teach No Class.';
        }
        else if(this.clazzes.length === 2){
            return super.introduce()+' I am a Teacher. I teach Class '+this.clazzes[0].number+','+this.clazzes[1].number+'.';
        }
    }

    isTeaching(student){
        let i=0;
        for(i=0;i<this.clazzes.length;i++){
            if(student.clazz.number === this.clazzes[i].number && student.clazz.hasStudent === true){
                return true;
            }
        }
        return false;
    }

    notifyStudentAppended(student){
     //    if(this.isTeaching(student) === true){
     //        return `${student.name} has joined Class ${student.clazz.number}.` ;
     //    }
    }

    notifyLeaderAssigned(student){
    //    if(this.isTeaching(student)===true&&student.clazz.leader === student.name ){
    //        return `${student.name} become Leader of Class ${student.clazz.number}.`;
    //    }
    }

}