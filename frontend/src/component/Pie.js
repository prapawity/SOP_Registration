import React, {useState,useEffect} from 'react'
import { makeStyles,withStyles } from '@material-ui/core/styles';
import { Pie } from 'react-chartjs-2';
const useStyle = makeStyles(theme => ({
    root:{
        width:'100%'
    }
}));
export default function Pies({props}){
    const [data,setData] = useState({
        labels: [
            'Red',
            'Blue',
        ],
        datasets: [{
            data: [60, 40],
            backgroundColor: [
            '#FF6384',
            '#FFCE56'
            ],
            hoverBackgroundColor: [
            '#FF6384',
            '#FFCE56'
            ]
        }]
    })
    let classes = useStyle()
    return(
        <div className={classes.root}>
        <h2>Pie Example</h2>
        <Pie data={data} />
      </div>
      );
}