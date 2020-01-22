package by.training.finance.dao.impl;


import by.training.finance.bean.Transaction;
import by.training.finance.dao.TransactionDAO;
import by.training.finance.dao.exception.DAOException;
import by.training.finance.dao.exception.InvalidFieldException;
import by.training.finance.dao.exception.InvalidParameterException;
import by.training.finance.dao.util.Converter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTransactionDAOImpl implements TransactionDAO {
    private static final String FULL_FILE_PATH = "E:/study/epam trainings/JavaCoreOffline/Finances/resource/transaction.txt";
    private static final String EMPTY_STRING = "";


    @Override
    public void add(Transaction transaction) throws DAOException {
        File file = checkFile();
        write(transaction, file);
    }

    @Override
    public Transaction[] getAll() throws DAOException {
        File file = checkFile();
        return readAll(file);
    }

    @Override
    public void update(long id, Transaction newTransaction) throws DAOException {
        File file = checkFile();
        Transaction[] data = readAll(file);
        clear(file);
        for (Transaction element : data) {
            if (element.getId() == id) {
                write(newTransaction, file);
            } else {
                write(element, file);
            }
        }
    }

    @Override
    public Transaction get(long id) throws DAOException {
        File file = checkFile();
        Transaction[] transactions = readAll(file);
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        throw new DAOException(String.format("Element with id %d not found in source", id));
    }

    @Override
    public void delete(int id) throws DAOException {
        File file = checkFile();
        Transaction[] transactions = readAll(file);
        clear(file);
        for (Transaction transaction : transactions) {
            if (transaction.getId() != id) {
                write(transaction, file);
            }
        }
    }

    private void clear(File file) throws DAOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            writer.write(EMPTY_STRING);
        } catch (IOException e) {
            throw new DAOException("Data source problems");
        }
    }

    private File checkFile() throws DAOException {
        File file = new File(FULL_FILE_PATH);
        if (!file.exists()) {
            throw new DAOException("Data source do not exist in given directory.");
        }
        return file;
    }

    private Transaction[] readAll(File file) throws DAOException {
        List<Transaction> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    list.add(Converter.parseToObject(line));
                } catch (InvalidParameterException e) {
                    throw new DAOException("Transmitted parameter is invalid", e);
                } catch (InvalidFieldException e) {
                    throw new DAOException("Transmitted parameter contains invalid fields", e);
                }
            }
        } catch (IOException e) {
            throw new DAOException("Data source problems", e);
        }
        return list.toArray(new Transaction[0]);
    }

    private void write(Transaction transaction, File file) throws DAOException {
        try (BufferedWriter stream = new BufferedWriter(new FileWriter(file, true))) {
            if (file.length() != 0) {
                stream.newLine();
            }
            try {
                stream.write(Converter.convertToString(transaction));
            } catch (InvalidParameterException e) {
                throw new DAOException("Transmitted parameter is invalid", e);
            } catch (InvalidFieldException e) {
                throw new DAOException("Transmitted parameter contains invalid fields", e);
            }
        } catch (IOException e) {
            throw new DAOException("Data source problems.", e);
        }
    }
}
