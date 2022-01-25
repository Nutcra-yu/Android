package com.example.criminalintent;

import android.content.Context;

public class CrimeLab
{
    private static CrimeLab sCrimeLab;

    private CrimeLab(Context context) { }

    public static CrimeLab get(Context context)
    {
        if (sCrimeLab == null )
        { sCrimeLab = new CrimeLab(context); }

        return sCrimeLab;
    }

}
