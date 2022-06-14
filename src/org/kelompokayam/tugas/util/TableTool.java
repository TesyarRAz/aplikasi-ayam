/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.kelompokayam.tugas.datasource.FileData;
import org.kelompokayam.tugas.datasource.FileListStorage;
import org.kelompokayam.tugas.datasource.FileStorage;

/**
 *
 * @author raz
 * @param <T>
 */
public class TableTool<T extends TableToolModel> {
    private JTable table;
    private FileListStorage<T> fileStorage;
    private List<Function<T, Boolean>> filters;
    
    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public FileListStorage<T> getFileStorage() {
        return fileStorage;
    }

    public void setFileStorage(FileListStorage<T> fileStorage) {
        this.fileStorage = fileStorage;
    }
    
    public boolean load() {
        try {
            FileData<List<T>> fileData = fileStorage.read();
            
            List<T> data = fileData.getData();
            
            if (data != null && !data.isEmpty()) {
                DefaultTableModel tableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int i, int i1) {
                        return false;
                    }
                };
                
                Map<String, Object> tableToolMap = data.get(0).toTableModel();
                
                tableToolMap.keySet().forEach(tableModel::addColumn);
                
                data.forEach((model) -> {
                    if (filters != null && !filters.isEmpty()) {
                        filters.forEach(filter -> {
                            if (filter.apply(model)) {
                                tableModel.addRow(model.toTableModel().values().toArray());
                            }
                        });
                    } else {
                        tableModel.addRow(model.toTableModel().values().toArray());
                    }
                });
                
                table.setModel(tableModel);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(table, "File anda crash", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }

    
    public void addFilter(Function<T, Boolean> filter) {
        if (filters == null) {
            filters = new ArrayList<>();
        }
        
        filters.add(filter);
    }
}
