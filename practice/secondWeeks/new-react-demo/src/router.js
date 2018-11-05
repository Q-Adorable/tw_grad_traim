import { BrowserRouter, Route, Link } from 'react-router-dom'

const Router =()=>(
    <BrowserRouter>
        <Link to="/">Home</Link>
        <Link to="/login" >login</Link>

        <Route exact path="/" component={Home} />
    </BrowserRouter>    
)

const Home = () => (
    <div>
      <h2>Home</h2>
    </div>
  );  
const login = () => (
    <div>
      <h2>login</h2>
    </div>
);