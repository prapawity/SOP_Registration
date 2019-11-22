import React, {useState,useEffect} from 'react'
import { makeStyles,withStyles } from '@material-ui/core/styles';
import { Bar } from 'react-chartjs-2';
const useStyle = makeStyles(theme => ({
    root:{
    }
}));
export default function ScoreBar({props}){
    let classes = useStyle()
    const [data,setData] = useState({
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [
          {
            label: 'My First dataset',
            backgroundColor: 'rgba(255,99,132,0.2)',
            borderColor: 'rgba(255,99,132,1)',
            borderWidth: 1,
            hoverBackgroundColor: 'rgba(255,99,132,0.4)',
            hoverBorderColor: 'rgba(255,99,132,1)',
            data: [65, 59, 80, 81, 56, 55, 40],
          }
        ]
      })
    return(
            <Bar
            width={1000}
            height={500}
            data={data}
            options={{ 
                maintainAspectRatio: false,
                responsive: true,
             }}
            />
    );
}
