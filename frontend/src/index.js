import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {Router,Route,Link} from 'react-router'
import { createBrowserHistory } from "history"
let browserHistory = createBrowserHistory()

ReactDOM.render(
    <Router history={browserHistory}>
        {/* <Route exact path="/" component={App}/>
        <Route path="/test2" component={Test}/>
        <Route path="/home" component={Navbar}/> */}
    </Router>,document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
