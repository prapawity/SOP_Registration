import React,{useEffect,useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: 'start',
    color: theme.palette.text.secondary,
    
  },
  bigAvatar: {
    margin: 10,
  },
  card: {
    minWidth: 275,
    height:'100%'
  },
  bullet: {
    display: 'inline-block',
    margin: '0 2px',
    transform: 'scale(0.8)',
  },
  title: {
    fontSize: 30,
    color:'black'
  },
  pos: {
    marginBottom: 12,
  },
  paper2: {
    padding: theme.spacing(2),
    textAlign: 'start',
    color: theme.palette.text.secondary,
    fontSize:20
  },
  paper3: {
    padding: theme.spacing(2),
    textAlign: 'start',
    color: 'black',
    fontSize:20
  },
}));

export default function Profile({props}) {
  const classes = useStyles();
  const [person, setPerson] = useState(props)
  useEffect(() => {
    // execute Loader
    // end
    console.log(props)
    
}, [])
  return (
    <div className={classes.root}>
      <Grid container spacing={1}>
        <Grid item xs={12} md={4}>
            <img alt="Remy Sharp" src="https://image.flaticon.com/icons/svg/149/149071.svg" className={classes.bigAvatar} />
        </Grid>
        <Grid item xs={12} md={8}>
            <Card className={classes.card}>
                <CardContent>
                    <Typography className={classes.title} gutterBottom>
                        Profile Information
                    </Typography>
                    <hr/>
                    <Grid container spacing={3} alignContent="flex-start" justify="flex-start">
                       
                      
                                <Grid item xs={12} md={3}>
                                    <Paper className={classes.paper2}>Name:</Paper>
                                </Grid>
                                <Grid item xs={12} md={3}>
                                  <Paper className={classes.paper3}>{person}</Paper>
                                </Grid>
                                <Grid item xs={12} md={3}>
                                    <Paper className={classes.paper2}>Surname:</Paper>
                                </Grid>
                                <Grid item xs={12} md={3}>
                                    <Paper className={classes.paper3}>Patthasirivichot</Paper>
                                </Grid>
                                
                    </Grid>
                </CardContent>
            </Card>
        </Grid>
      </Grid>
    </div>
  );
}