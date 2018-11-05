import React from 'react';
import Todo from './Todo'
import { connect } from 'react-redux'

const TodoList = ({todos,toggleAll}) =>{
    return (
    <section className="main">
      <input id="toggle-all" className="toggle-all" type="checkbox" 
      onClick={(e)=>{
        toggleAll(e.target.checked)
      }}
      />
      <label htmlFor="toggle-all">Mark all as complete</label>
      <ul className="todo-list">
        {
          todos.map((item, key) => (
            <Todo key={key} idx={key} {...item} />
          ))
        }
      </ul>
    </section>
    )
}

const mapStateToProps = ({todos})=>{
    return{
        todos:todos
    }
}
const mapDispatchToProps =(dispatch)=>({
  toggleAll: (checked) => {
    dispatch({
      type: 'TOGGLE_ALL',
      data: checked
    })
  }
})

export default connect(mapStateToProps, mapDispatchToProps)(TodoList);