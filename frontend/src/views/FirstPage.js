import React, {useEffect, useState} from 'react';
import '../assets/FirstPage.css';
import axios from 'axios';
import PrimarySearchAppBar from '../component/navbar';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
// template to use loader and axios

const useStyles = makeStyles(theme => ({
    root: {
      flexGrow: 1,
    },
    paper: {
      padding: theme.spacing(0),
      textAlign: 'center',

    },
  }));

function FirstPage() {
    const [person, setPerson] = useState({})
    const classes = useStyles();
    useEffect(() => {

        axios.get('https://pokeapi.co/api/v2/pokemon/ditto/').then(res => {
            const persons = res.data;
            setPerson(persons)

            // execute Loader
            var delayInMilliseconds = 3000; //3 second
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
    <div className={classes.root}>
        <Grid container spacing={3}>
            <Grid item xs={12}>
                <Paper className={classes.paper}>
                    <PrimarySearchAppBar/>
                </Paper>
            </Grid>

            
        </Grid>
    </div>
    );
    
}
export default FirstPage