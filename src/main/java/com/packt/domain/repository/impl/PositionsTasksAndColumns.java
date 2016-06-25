package com.packt.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Winiu on 22-06-2016.
 */
public class PositionsTasksAndColumns {
    private String[] rawListOrder;
    private long[] longListOrder;
    private String[] rawListOrderTasks;
    private List<OrderTasks> listOrderTasks= new ArrayList<>();

    public long[] generateOrderColumn(String listOrderfromView)
    {
        rawListOrder=listOrderfromView.split(",");
        longListOrder=new long[rawListOrder.length];
        for(int i=0;i<rawListOrder.length; i++)
        {
            System.out.println("W petli _ "+ rawListOrder[i]);
            longListOrder[i]=Long.parseLong(rawListOrder[i], 10);
        }
        return longListOrder;
    }

    public List<OrderTasks> generateOrderTasks (String listOrderFromView)
    {
        String[] orderSplit;
        rawListOrderTasks=listOrderFromView.split(",");
        for (int i=0;i<rawListOrderTasks.length;i++ )
        {
            orderSplit=rawListOrderTasks[i].split(":");
            listOrderTasks.add(new OrderTasks(Long.parseLong(orderSplit[0],10),Long.parseLong(orderSplit[1],10)));
        }

        return listOrderTasks;
    }

    public class OrderTasks
    {
        long idColumn;
        long idTask;
        public long getIdTask() {
            return idTask;
        }

        public void setIdTask(long idTask) {
            this.idTask = idTask;
        }

        public long getIdColumn() {
            return idColumn;
        }

        public void setIdColumn(long idColumn) {
            this.idColumn = idColumn;
        }

        public OrderTasks(long idColumn, long idTask) {
            this.idTask = idTask;
            this.idColumn = idColumn;
        }


    }

}
