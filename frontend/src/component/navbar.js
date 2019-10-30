import React from 'react';
import Grid from '@material-ui/core/Grid';
import '../assets/navbar.css'
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import Fab from '@material-ui/core/Fab';
import NavigationIcon from '@material-ui/icons/Navigation';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import ChevronRightIcon from '@material-ui/icons/ChevronRight';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import MailIcon from '@material-ui/icons/Mail';
import Button from '@material-ui/core/Button';

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    height: 140,
    width: 100,
  },
  control: {
    padding: theme.spacing(2),
  },
  margin: {
    margin: theme.spacing(1),
  },
  button: {
    margin: theme.spacing(1),
  },
  input: {
    display: 'none',
  },
}));

const useStyles2 = makeStyles(theme => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
}));


const drawerWidth = 240;

const useStyles3 = makeStyles(theme => ({
  root: {
    display: 'flex',
  },
  appBar: {
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  appBarShift: {
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
    marginRight: drawerWidth,
  },
  title: {
    flexGrow: 1,
  },
  hide: {
    display: 'none',
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
  },
  drawerHeader: {
    display: 'flex',
    alignItems: 'center',
    padding: theme.spacing(0, 1),
    ...theme.mixins.toolbar,
    justifyContent: 'flex-start',
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    marginRight: -drawerWidth,
  },
  contentShift: {
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
    marginRight: 0,
  },
}));

export default function PrimarySearchAppBar() {
  const [spacing, setSpacing] = React.useState(2);
  const classes = useStyles();
  const classes2 = useStyles2();
  const classes3 = useStyles3();
  const theme = useTheme();
  const [open, setOpen] = React.useState(false);
  const handleDrawerOpen = () => {
    setOpen(true);
  };
  const handleDrawerClose = () => {
    setOpen(false);
  };
  return (
    <div className="nav">
      <div className={classes2.root}>
      <AppBar position="static">
        <Toolbar variant="dense">
            <Grid container className={classes.root} spacing={1}>
              <Grid item xs={2}>
                <Grid container justify="flex-start" spacing={spacing}>
                  <div className="title">
                    <h2>
                      HongFah
                    </h2>
                  </div>
                </Grid>
              </Grid>
              <Grid item xs={8}>
                <Grid className="notburger" container justify="center" spacing={0}>
                  <div className="detail-title">
                    <Button className={classes.button}>Home</Button>
                  </div>
                  <div className="detail-title">

                    <Button className={classes.button}>Class</Button>
                  </div>
                  <div className="detail-title">

                    <Button className={classes.button}>Precision</Button>
                  </div>
                  <div className="detail-title">
                   
                    <Button className={classes.button}>Contact</Button>
                  </div>
                </Grid>
              </Grid>
              <Grid item xs={2}>
                <Grid container justify="flex-end" spacing={spacing}>
         
                    <div className="notburger">
                        <Fab
                          variant="extended"
                          size="medium"
                          color="primary"
                          aria-label="add"
                          className={classes.margin}>         
                        <NavigationIcon className={classes.extendedIcon} />
                        <div id="getstart">
                          Get Started
                        </div>
                      </Fab>
                    </div>
                  <div className="burger">
                    <IconButton edge="start" className={classes.menuButton} color="primary" aria-label="menu" onClick={handleDrawerOpen}>
                      <MenuIcon />
                    </IconButton>
                    {/* <IconButton
                      color="secondary"
                      aria-label="open drawer"
                      edge="end"
                      onClick={handleDrawerOpen}
                      className={clsx(open && classes.hide)&&classes.menuButton}>
                    </IconButton> */}
                  </div>
           
                </Grid>
              </Grid>
          </Grid>
        </Toolbar>
      </AppBar>
    </div>
    <Drawer
        className={classes3.drawer}
        variant="persistent"
        anchor="right"
        open={open}
        classes={{
          paper: classes.drawerPaper,
        }}
      >
        <div className={classes3.drawerHeader}>
          <IconButton onClick={handleDrawerClose}>
            {theme.direction === 'rtl' ? <ChevronLeftIcon /> : <ChevronRightIcon />}
          </IconButton>
        </div>
        <Divider />
        <List>
          {['Home', 'Class', 'Precision', 'Contact'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon>{index % 2 === 0 ? <InboxIcon /> : <MailIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
      </Drawer>
 
    </div>
  );
}

{/* <Typography variant="h6" color="inherit">
Photos
</Typography>
<IconButton edge="start" className={classes2.menuButton} color="inherit" aria-label="menu">
<MenuIcon />
</IconButton> */}