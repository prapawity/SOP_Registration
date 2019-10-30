import React from 'react'
import '../assets/footer.css'
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import {
    BrowserRouter as Link
  } from "react-router-dom";

const useStyles = makeStyles({

    title: {
      fontSize: 14,
    }

  });
  export default function Footer() {
    const classes = useStyles();
    return(
        <div className="footer">
            <Typography className={classes.title} color="textSecondary" gutterBottom>
                &copy; {new Date().getFullYear()} Copyright: <a color="textSecondary" href="https://www.it.kmitl.ac.th/th/"> IT @ KMITL </a>
            </Typography>
             
        </div>
    );
}