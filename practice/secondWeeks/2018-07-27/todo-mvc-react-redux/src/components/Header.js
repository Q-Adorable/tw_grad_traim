import React from 'react'
import { connect } from 'react-redux'

const Header =({addTodo})=>{
    return(
        <header className="header">
			<h1>todos</h1>
            <input className="new-todo" 
            onKeyPress={
                (e)=>{
                    const label=e.target.value.trim();
                    if(e.charCode === 13 && label!==''){
                        addTodo(label);
                        e.target.value='';
                    }
                }
            }
            placeholder="What needs to be done?" autoFocus />
		</header>
    )
}


const mapStateToProps = ()=>({})
const mapDispatchToProps =(dispatch)=>({
    addTodo:(label)=>{
        dispatch({
            type:'ADD_TODO',
            label
        })
    }
})

export default connect(mapStateToProps, mapDispatchToProps)(Header);