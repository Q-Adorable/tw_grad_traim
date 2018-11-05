
class MyInput extends React.Component{
    render(){
        return (
            <input type="text"  onChange={(event)=>{ }}/>
        );
    }
}
const mapStateToProps = (state) => {
    console.log(state); 
}
export default MyInput;