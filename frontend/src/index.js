import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import {Router,Route,Link} from 'react-router'
import { createBrowserHistory } from "history"
import firstPage from './views/FirstPage'
import SignIn from './views/signIn'
import Loaders from './component/loader';
import StudentProfile from './views/Student/studentProfiel'
import TeacherProfile from './views/Teacher/teacherProfile'
import ScoreStudent from './views/Student/studentScore'
import CheckStudent from './views/Student/studentCheck'
import PredictStudent from './views/Student/studentPrediction'
import TeacherScore from './views/Teacher/teacherScore'
import StudentDashboard from './views/Student/studentDashboard'
let browserHistory = createBrowserHistory()

ReactDOM.render(
    <Router history={browserHistory}>
        <Loaders/>
        <Route exact path="/" component={firstPage}/>
        <Route exact path="/signin" component={SignIn}/>
        {/* Student */}
        <Route exact path="/student/profile" component={StudentProfile}/>
        <Route exact path="/student/score" component={ScoreStudent}/>
        <Route exact path="/student/check" component={CheckStudent}/>
        <Route exact path="/student/predict" component={PredictStudent}/>
        <Route exact path="/student/dashboard" component={StudentDashboard}/>

        {/* Teacher */}
        <Route exact path="/teacher/profile" component={TeacherProfile}/> 
        <Route exact path="/teacher/score" component={TeacherScore}/> 
        {/* Hongfah */}
        {/* <Route exact path="/" component={App}/>
        <Route path="/test2" component={Test}/>
        <Route path="/home" component={Navbar}/> */}
    </Router>,document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
