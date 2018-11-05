import React from 'react'
import { connect } from 'react-redux'

const Footer = ({clearCompleted,getAll,getActive,getCompleted}) => {
    return (
        <footer className="footer">
        <span className="todo-count">
            <strong>0</strong> item left
        </span>
        <ul className="filters">
            <li>
                <a onClick={()=>{getAll()}} className="selected all" href="#/">All</a>
            </li>
            <li>
                <a onClick={()=>{getActive()}} className="active" href="#/active">Active</a>
            </li>
            <li>
                <a onClick={()=>{getCompleted()}} className="completed" href="#/completed">Completed</a>
            </li>
        </ul>
        <button onClick={()=>{clearCompleted()}} className="clear-completed">Clear completed</button>
    </footer>
    )
}
const mapStateToProps = ({todos})=>({
    leftCount: todos.filter(todo => !todo.completed).length
})
const mapDispatchToProps =(dispatch)=>({
    clearCompleted: ()=> {
        dispatch({
          type: 'CLEAR_COMPLETED'
        })
    },
    getAll: ()=> {
        dispatch({
          type: 'ALL'
        })
    },
    getActive: ()=> {
        dispatch({
          type: 'ACTIVE'
        })
    },
    getCompleted: ()=> {
        dispatch({
          type: 'COMPLETED'
        })
    }
})

export default connect(mapStateToProps, mapDispatchToProps)(Footer)