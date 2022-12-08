public class TableManipulate {
    //Retrieve the column names without having to use a separate sql query to fetch it.
    static String[] columnNames;
    static Object[][] data;
    public static String[] getColumnName(Object[][] dataTemp){
        columnNames = new String[dataTemp[0].length];
        for(int i = 0; i < dataTemp[0].length; i++){
            columnNames[i] = (String) dataTemp[0][i];
        }
        return columnNames;
    }

    public static Object[][] getTableData(Object[][] dataTemp){
        data = new Object[dataTemp.length-1][dataTemp[0].length];

        for(int i = 1; i < dataTemp.length; i++){ //start at 2nd row
            System.arraycopy(dataTemp[i], 0, data[i - 1], 0, dataTemp[0].length);
        }
        return data;
    }
}
