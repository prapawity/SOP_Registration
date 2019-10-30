import React, {useEffect, useState} from 'react';
import '../assets/FirstPage.css';
import axios from 'axios';
import PrimarySearchAppBar from '../component/navbar';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Footer from '../component/footer'
import Slider from 'react-animated-slider';
import 'react-animated-slider/build/horizontal.css';


// import
const useStyles = makeStyles(theme => ({
    root: {
      flexGrow: 1,
    },
    paper: {
      padding: theme.spacing(0),
      textAlign: 'center',

    },
    card: {
        minWidth: 275,
      },
      bullet: {
        display: 'inline-block',
        margin: '0 2px',
        transform: 'scale(0.8)',
      },
      title: {
        fontSize: 14,
      },
      pos: {
        marginBottom: 12,
      },
      widths:{
      },
      button: {
        margin: theme.spacing(1),
      },
      input: {
        display: 'none',
      },
      trybtn:{
          
      },
      last_component:{
          
      }
  }));

function FirstPage() {
    const [person, setPerson] = useState({})
    const classes = useStyles();
    const bull = <span className={classes.bullet}>•</span>;



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
            <Grid item xs={12} className="centerg">
                <Grid container spacing={3}>
                    <Grid container justify="center" item xs={12} md={4} className="grid2" >
                        <Card className={`${classes.card} ${classes.widths}`}>
                            <CardContent>
                                <Typography variant="h4" component="h2">
                                    Learning online is easier than ever before
                                </Typography>
                                <Typography variant="body2" color="textSecondary" component="p">
                                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                                </Typography>
                            </CardContent>
                            <Button variant="outlined" color="primary" className={`${classes.button} ${classes.trybtn}`}>
                                Primary
                            </Button>
                        </Card>
                    </Grid>
                    <Grid container justify="center" item xs={12} md={8} >
                        {/* <img className="img_tab" src={require('../assets/images/itkmitl.jpg')} /> */}
                        <Slider autoplay={1500}>
                            <div key={0} style={{ background: `url(${require('../assets/images/test2.jpg')}) no-repeat center center` }}></div>
                            <div key={1} style={{ background: `url(${require('../assets/images/test.jpg')}) no-repeat center center` }}></div>
                            <div key={2} style={{ background: `url(${require('../assets/images/test2.jpg')}) no-repeat center center` }}></div>
                            <div key={3} style={{ background: `url(${require('../assets/images/itkmitl.jpg')}) no-repeat center center` }}></div>
                            <div key={4} style={{ background: `url(${require('../assets/images/test2.jpg')}) no-repeat center center` }}></div>
                        </Slider>
                    </Grid>
                </Grid>
            </Grid>
        </Grid>
        <Grid container spacing={3} className="ink">
            <Grid container justify="flex-end" item xs={12} className="centerg-ink" >
                <img className="img_right" src={require('../assets/images/test.jpg')} />
            </Grid>
        </Grid>
        <Grid container spacing={3}>
            <Grid item xs={12} className="centerg">
                <Grid container spacing={3}>
                    <Grid container justify="center" item xs={12} sm={6} >
                        
                            <img className="img_2" src={require('../assets/images/test2.jpg')} />
                        
                    </Grid>
                    <Grid container justify="center" item xs={12} sm={6} >
                        
                            <img className="img_2" src={require('../assets/images/test2.jpg')} />
                       
                    </Grid>
                </Grid>
            </Grid>
        </Grid>
        <Grid container spacing={3}>
            <Grid container justify="center" item xs={12} className="centerz">
                <Card className={classes.last_component}>
                    <CardContent>
                        <Typography variant="h4" component="h2">
                            Learning online is easier than ever before
                        </Typography>
                        <Typography variant="body2" color="textSecondary" component="p">
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                        </Typography>
                    </CardContent>
                    <Button variant="outlined" color="primary" className={`${classes.button} ${classes.trybtn}`}>
                        Primary
                    </Button>
                </Card>
            </Grid>

        </Grid>
        <Footer/>

    </div>
    );
    
}
export default FirstPage