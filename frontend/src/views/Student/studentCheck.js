import React,{useEffect,useState} from 'react';
import axios from 'axios';
import clsx from 'clsx';
import { makeStyles,withStyles } from '@material-ui/core/styles';
import CssBaseline from '@material-ui/core/CssBaseline';
import Drawer from '@material-ui/core/Drawer';
import Box from '@material-ui/core/Box';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import Badge from '@material-ui/core/Badge';
import Container from '@material-ui/core/Container';
import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import NotificationsIcon from '@material-ui/icons/Notifications';
import { mainListItems, secondaryListItems } from '../../component/sidenavStudent';
import Footer from '../../component/footer'
import Fab from '@material-ui/core/Fab';
import Avatar from '@material-ui/core/Avatar';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import ListItemText from '@material-ui/core/ListItemText';
import SendIcon from '@material-ui/icons/Send';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import Scatter from '../../component/Scatter'
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';

const drawerWidth = 240;

const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex',
  },
  toolbar: {
    paddingRight: 24, // keep right padding when drawer closed
  },
  toolbarIcon: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-end',
    padding: '0 8px',
    ...theme.mixins.toolbar,
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  appBarShift: {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  menuButton: {
    marginRight: 36,
  },
  menuButtonHidden: {
    display: 'none',
  },
  title: {
    flexGrow: 1,
  },
  drawerPaper: {
    position: 'relative',
    whiteSpace: 'nowrap',
    width: drawerWidth,
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  drawerPaperClose: {
    overflowX: 'hidden',
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    width: theme.spacing(7),
    [theme.breakpoints.up('sm')]: {
      width: theme.spacing(9),
    },
  },
  appBarSpacer: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    height: '100vh',
    overflow: 'auto',
  },
  container: {
    paddingTop: theme.spacing(3),
    paddingBottom: theme.spacing(3),
    paddingLeft:theme.spacing(0),
    paddingRight:theme.spacing(0),
  },
  paper: {
    padding: theme.spacing(2),
    display: 'flex',
    overflow: 'auto',
    flexDirection: 'column',
  },
  fixedHeight: {
    height: 240,
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
    fontWeight: theme.typography.fontWeightRegular,
  },
  con:{
      textAlign: 'center'
  }
}));


const StyledMenu = withStyles({
  paper: {
    border: '1px solid #d3d4d5',
  },

})(props => (
  <Menu
    elevation={0}
    getContentAnchorEl={null}
    anchorOrigin={{
      vertical: 'bottom',
      horizontal: 'center',
    }}
    transformOrigin={{
      vertical: 'top',
      horizontal: 'center',
    }}
    {...props}
  />
));


const StyledMenuItem = withStyles(theme => ({
  root: {
    '&:focus': {
      backgroundColor: theme.palette.primary.main,
      '& .MuiListItemIcon-root, & .MuiListItemText-primary': {
        color: theme.palette.common.white,
      },
    },
  },
}))(MenuItem);


export default function CheckClass() {



  const classes = useStyles();
  const [open, setOpen] = React.useState(false);
  const [anchorEl, setAnchorEl] = React.useState(null);
  const handleClick = event => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
  const handleDrawerOpen = () => {
    setOpen(true);
  };
  const handleDrawerClose = () => {
    setOpen(false);
  };
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);


  const [person, setPerson] = useState({})

  const [listA,setA] = useState([1,2,3,4,5])

  useEffect(() => {
    // execute Loader
    
    var delayInMilliseconds = 3000; //3 second
    var test = document.getElementsByClassName('MuiPaper-root');
    for(var i = 0; i < test.length; i++) { 
        test[i].style.display='none'
    }
    axios.get('https://pokeapi.co/api/v2/pokemon/ditto/').then(res => {
    setTimeout(function() {
    //your code to be executed after 2 second
        var eggs = document.getElementsByClassName('loader');
        for(var i = 0; i < eggs.length; i++) { 
            eggs[i].style.display='none'
        }
        for(var i = 0; i < test.length; i++) { 
            test[i].style.display='block'
        }
    }, delayInMilliseconds);})
    // end
    
}, [])


  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar position="absolute" className={clsx(classes.appBar, open && classes.appBarShift)}>
        <Toolbar className={classes.toolbar}>
          <IconButton
            edge="start"
            color="inherit"
            aria-label="open drawer"
            onClick={handleDrawerOpen}
            className={clsx(classes.menuButton, open && classes.menuButtonHidden)}
          >
            <MenuIcon />
          </IconButton>
          <Typography component="h1" variant="h6" color="inherit" noWrap className={classes.title}>
            Score
          </Typography>
        <Fab
            aria-controls="customized-menu"
            aria-haspopup="true"

            onClick={handleClick} id="avatar">
            <Avatar alt="Remy Sharp" src={require("../../assets/avatar.svg")} className={classes.Avatar} />
        </Fab>
      <StyledMenu
        id="customized-menu"
        anchorEl={anchorEl}
        keepMounted
        open={Boolean(anchorEl)}
        onClose={handleClose}
      >
        <StyledMenuItem>
          <ListItemIcon>
            <SendIcon fontSize="small" />
          </ListItemIcon>
          <ListItemText primary="Profile" />
        </StyledMenuItem>
        <StyledMenuItem>
          <ListItemIcon>
            <InboxIcon fontSize="small" />
          </ListItemIcon>
          <ListItemText primary="LogOut" />
        </StyledMenuItem>
      </StyledMenu>
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        classes={{
          paper: clsx(classes.drawerPaper, !open && classes.drawerPaperClose),
        }}
        open={open}
      >
        <div className={classes.toolbarIcon}>
          <IconButton onClick={handleDrawerClose}>
            <ChevronLeftIcon />
          </IconButton>
        </div>
        <Divider />
        <List>{mainListItems}</List>
        <Divider />
        <List>{secondaryListItems}</List>
      </Drawer>
      <main className={classes.content}>
        <div className={classes.appBarSpacer} />
        <Container maxWidth="lg" className={classes.container}>
        <div>
            {
                listA.map((value)=>{
                    return <ExpansionPanel>
                    <ExpansionPanelSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel1a-content"
                    id="panel1a-header"
                    >
                    <Typography className={classes.heading}>Expansion Panel 1</Typography>
                    </ExpansionPanelSummary>
                    <ExpansionPanelDetails>
                        <Scatter/>
                    </ExpansionPanelDetails>
                </ExpansionPanel>
                })
            }
        </div>
          <Box pt={4}>
            <Footer />
          </Box>
        </Container>
      </main>
    </div>
  );
}