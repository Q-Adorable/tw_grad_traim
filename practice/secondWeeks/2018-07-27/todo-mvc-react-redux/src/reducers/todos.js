const initState = [
    { label: 'javascript', completed: true },
    { label: 'java' }
  ]

const todos=(state=initState,action)=>{
    switch(action.type){
        case 'ADD_TODO':
            const newState=[...state];
            newState.push({label:action.label});
            return newState;
        case 'TOGGLE_TODO':
            return state.map((item, idx) => {
                return Object.assign({}, item, {
                    completed: idx === action.idx ? !item.completed : item.completed
                })
            })
        case 'TOGGLE_ALL':
            return state.map((item) => {
              return Object.assign({}, item, {
                completed: action.data
              })
            })
        case 'DELETE_TODO':
            state.splice(action.idx,1);
            return state.map((item) => {
                return Object.assign({}, item, {})
            })
        case 'CLEAR_COMPLETED':
            return state.filter(todo => !todo.completed)
        case 'ALL':
            return state.map((item) => {
                return Object.assign({}, item, {})
            }) 
        case 'ACTIVE':
            return state.filter(todo => !todo.completed)
        case 'COMPLETED':
            return state.filter(todo => todo.completed)
        default:
            return state;
    }
}

export default todos;