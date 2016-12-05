/*
package com.example.wyz.calculator;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.sql.Struct;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;



*/
/**
 * Created by Wyz on 2016/4/4.
 *//*

public class ContentProvider {

    public static char Opset[]=new char[]{'+','-','*','/','#'};

    class DataStack
    {
        public  int top;

        public  char data[]=new char[100];
    }
    public static void Init_Stack(DataStack dataStack )
    {
        dataStack.top=-1;
    }
    public static void Push_Stack(DataStack dataStack,char data)
    {
        dataStack.top+=1;
        dataStack.data[dataStack.top]=data;
    }
    public  static int  Empty_Stack(DataStack  dataStack)
    {
        if(dataStack.top==-1)
        {
            return 0;
        }
        return 1;
    }
    public static  char  Pop_Stack(DataStack dataStack)
    {
        char data= dataStack.data[dataStack.top];
        dataStack.top-=1;
        return data;
    }
    public  static  char GetTop_Stack(DataStack dataStack)
    {
        char data= dataStack.data[dataStack.top];
        return data;
    }
    public static  int  IsOpset(char ch)
    {
        int i=0;
        for (char ch1:Opset) {
            if(ch==ch1)
            {
                return 1;
            }
        }
        return 0;
    }


}
*/
