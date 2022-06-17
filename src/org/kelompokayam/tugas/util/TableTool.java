/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.kelompokayam.tugas.datasource.FileData;
import org.kelompokayam.tugas.datasource.FileListStorage;

/**
 *
 * @author raz
 * @param <T>
 */
public class TableTool<T extends TableToolModel> {
    private JTable table;
    private FileListStorage<T> fileStorage;
    private List<Predicate<T>> filters;
    private List<Consumer<List<T>>> afterLoads;
    private List<String> headers;
    
    private List<T> filteredData;
    private List<T> data;
    
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
            
            data = fileData.getData();
            
            DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }
            };
            
            if (data != null && !data.isEmpty()) {
                filteredData = data.stream().filter(model -> {
                    if (filters != null && !filters.isEmpty()) {
                        for (Predicate<T> filter : filters) {
                            if (!filter.test(model)) {
                                return false;
                            }
                        }
                    }
                    
                    return true;
                }).collect(Collectors.toList());
                
                if (headers != null) {
                    headers.forEach(tableModel::addColumn);
                } else {
                    Map<String, Object> tableToolMap = data.get(0).toTableModel();
                
                    tableToolMap.keySet().forEach(tableModel::addColumn);
                }
                
                filteredData.forEach((model) -> {
                    tableModel.addRow(model.toTableModel().values().toArray());
                });
                
                if (afterLoads != null && !afterLoads.isEmpty()) {
                    afterLoads.forEach(e -> e.accept(filteredData));
                }
            } else {
                if (headers != null && !headers.isEmpty()) {
                    headers.forEach(tableModel::addColumn);
                }
            }
            
            table.setModel(tableModel);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(table, "File anda crash", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }

    public void addFilter(Predicate<T> filter) {
        if (filters == null) {
            filters = new ArrayList<>();
        }
        
        filters.add(filter);
    }
    
    public void addAfterLoad(Consumer<List<T>> runner) {
        if (afterLoads == null) {
            afterLoads = new ArrayList<>();
        }
        
        afterLoads.add(runner);
    }

    public List<Predicate<T>> getFilters() {
        return filters;
    }

    public void setFilters(List<Predicate<T>> filters) {
        this.filters = filters;
    }

    public List<Consumer<List<T>>> getAfterLoads() {
        return afterLoads;
    }

    public void setAfterLoads(List<Consumer<List<T>>> afterLoads) {
        this.afterLoads = afterLoads;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<T> getFilteredData() {
        return filteredData;
    }

    public List<T> getData() {
        return data;
    }
}
