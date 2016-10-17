package com.test.tt101301.data;

import android.content.Context;
import android.support.annotation.Nullable;

/**
 * Created by teacher on 2016/10/17.
 */

public class StudentDAOFactory {
    @Nullable
    public static StudentDAO createStudentDAO(Context context, String type)
    {
        switch (type)
        {
            case "File":
                return new StudentDAOFileImpl(context);
            case "DB":
                return new StudentDAODBImpl(context);
        }
        return null;
    }
}
