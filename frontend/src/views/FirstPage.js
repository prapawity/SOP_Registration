import React, {useEffect, useState} from 'react';
import '../assets/FirstPage.css';
import axios from 'axios';
// template to use loader and axios
function FirstPage() {
    const [person, setPerson] = useState("")
    useEffect(() => {

        axios.get('https://pokeapi.co/api/v2/pokemon/ditto/').then(res => {
            const persons = res.data;
            setPerson(persons.name)

            // execute Loader
            var delayInMilliseconds = 2000; //2 second
            setTimeout(function() {
            //your code to be executed after 2 second
                var eggs = document.getElementsByClassName('loader');
                for(var i = 0; i < eggs.length; i++) { 
                    eggs[i].style.display='none'
            }
            }, delayInMilliseconds);
            // end

        })
        
    }, [])
    return(
        
    <div className="test">
        <h1>{person}</h1>
    </div>
    );
    
}
export default FirstPage