package com.glqdlt.showprojectstructuretree;

import java.io.File;

public class Utill {

    public static StringBuilder renderFolder(File folder, int level, StringBuilder sb, boolean isLast)
    {
        indent(sb, level, isLast).append(folder.getName()).append("\n");

        File[] objects = folder.listFiles();

        for (int i = 0; i < objects.length; i++)
        {
            boolean last = ((i + 1) == objects.length);

            if (objects[i].isDirectory())
            {
                renderFolder(objects[i], level + 1, sb, last);
            }
            else
            {
                renderFile(objects[i], level + 1, sb, last);
            }
        }

        return sb;
    }

    private static StringBuilder renderFile(File file, int level, StringBuilder sb, boolean isLast)
    {
        return indent(sb, level, isLast).append("── ").append(file.getName()).append("\n");
    }

    private static StringBuilder indent(StringBuilder sb, int level, boolean isLast)
    {
        for (int i = 1; i < level; i++)
        {
            sb.append("│   ");
        }

        if (level > 0)
        {
            sb.append(isLast
                    ? "└─"
                    : "├─");
        }

        return sb;
    }

}
