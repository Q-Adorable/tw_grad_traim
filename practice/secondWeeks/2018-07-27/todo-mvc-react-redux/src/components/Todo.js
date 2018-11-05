import React, { Component } from 'react';
import { connect } from 'react-redux'

class Todo extends Component{
    state = {
		editing: false
	}

    render(){
        const { label, completed=false, toggleTodo,deleteTodo, idx } = this.props
        let clazz = completed ? 'completed' : '';
        if(this.state.editing) {
			clazz += ' editing'
		}

        return(
            <li className={clazz}>
				<div className="view">
                    <input className="toggle" type="checkbox" 
                        checked={completed}
                        onClick={()=>{
                            toggleTodo(idx);
                        }}/>
					<label>{label}</label>
					<button onClick={()=>{
                        deleteTodo(idx)
                    }} className="destroy"></button>
				</div>
                <input class="edit" value="Create a TodoMVC template" />
			</li>
        )
    }
}



const mapStateToProps = ()=>({})
const mapDispatchToProps =(dispatch)=>({
    toggleTodo: (idx) => {
		dispatch({
			type: 'TOGGLE_TODO',
			idx
		})
    },
        deleteTodo: (idx) => {
            dispatch({
                type: 'DELETE_TODO',
                idx
            })
        }
})

export default connect(mapStateToProps, mapDispatchToProps)(Todo);