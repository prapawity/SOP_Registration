import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import {Router,Route,Link} from 'react-router'
import { createBrowserHistory } from "history"
import firstPage from './views/FirstPage'
import Loaders from './component/loader';
let browserHistory = createBrowserHistory()

ReactDOM.render(
    <Router history={browserHistory}>
        <Loaders/>
        <Route path="/" component={firstPage}/>
        {/* <Route exact path="/" component={App}/>
        <Route path="/test2" component={Test}/>
        <Route path="/home" component={Navbar}/> */}
    </Router>,document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
