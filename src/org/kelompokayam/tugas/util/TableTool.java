/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToolTip;
import javax.swing.event.MouseInputListener;
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
    private List<Consumer<List<T>>> afterLoadsUnfiltered;
    private List<String> headers;
    
    private List<T> filteredData;
    private List<T> data;
    
    private MouseListener oldMl;
    
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
                    if (filters != null) {
                        return filters.stream().allMatch(e -> e.test(model));
                    }
                    
                    return true;
                }).collect(Collectors.toList());
                
                Collection<String> headers = this.headers;
                
                if (headers == null) {
                    headers = data.get(0).toTableModel().keySet();
                }
                
                table.removeMouseListener(oldMl);
                
                final Collection<String> cHeaders = headers;
                table.addMouseListener(oldMl = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        int row = table.rowAtPoint(me.getPoint());
                        
                        cHeaders.stream().filter(e -> e.startsWith("_")).forEach(e -> {
                            if (e.equalsIgnoreCase("_tooltip")) {
                                T data = filteredData.get(row);
                                
                                if (data != null) {
                                    table.setToolTipText(data.toTableModel().get(e).toString());
                                }
                            }
                        });
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {}

                    @Override
                    public void mouseReleased(MouseEvent me) {}

                    @Override
                    public void mouseEntered(MouseEvent me) {}

                    @Override
                    public void mouseExited(MouseEvent me) {}
                });
                
                headers.removeIf(e -> e.startsWith("_"));
                
                headers.forEach(tableModel::addColumn);
                
                final Collection<String> fHeaders = headers;
                
                filteredData.stream()
                        .map(model -> model.toTableModel().entrySet().stream()
                            .filter(e -> fHeaders.contains(e.getKey()))
                            .map(e -> e.getValue())
                            .toArray()
                        )
                        .forEach(tableModel::addRow);
                
                if (afterLoadsUnfiltered != null) {
                    afterLoadsUnfiltered.forEach(e -> e.accept(data));
                }
                
                if (afterLoads != null) {
                    afterLoads.forEach(e -> e.accept(filteredData));
                }
            } else {
                if (headers != null) {
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
    
    public void addAfterLoadUnfiltered(Consumer<List<T>> runner) {
        if (afterLoadsUnfiltered == null) {
            afterLoadsUnfiltered = new ArrayList<>();
        }
        
        afterLoadsUnfiltered.add(runner);
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

    public List<Consumer<List<T>>> getAfterLoadsUnfiltered() {
        return afterLoadsUnfiltered;
    }

    public void setAfterLoadsUnfiltered(List<Consumer<List<T>>> afterLoadsUnfiltered) {
        this.afterLoadsUnfiltered = afterLoadsUnfiltered;
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
