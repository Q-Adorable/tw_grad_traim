import React, {Component} from 'react';

class Todo extends Component {
    constructor(props){
        super(props);
        this.state = {editing:false};
    }

    render() {
        let clazz = "completed";
        if(this.state.editing === true){
            clazz += " editing"
        }
        return (<li className= {clazz}>
            <div className="view">
                <input className="toggle" type="checkbox" checked/>
                <label>{this.props.item.label}</label>
                <button className="destroy"
                        onClick={() => this.props.onDestroy()}></button>
            </div>
            <input className="edit" value={this.props.item.label}/>
        </li>);
    }
}

export default Todo;