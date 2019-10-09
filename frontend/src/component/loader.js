import React, {useState} from 'react'
import '../assets/loader.css'
import "react-loader-spinner/dist/loader/css/react-spinner-loader.css"
import Loader from 'react-loader-spinner'


function Loaders() {
    const [timers, setTimer] = useState(10000);
    return(
    <div className="loader">
        <Loader className="loadCenter"
         type="Triangle"
         color="#FFFFFF"
         height={300}
         width={300}
         timeout={100000} //3 secs
         />
    </div>
    );
}
export default Loaders