package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FileHandler {

    // Paths.getPointer() can throw InvalidPathException
    // Files.readAllLines() can throw IOException

    final static boolean NO_COMMENT_LINES = true;

    /**
     * Returns all lines in a file not including empty lines.
     *
     * @param fileUri
     * @return List\<String\> lines
     * @throws InvalidPathException
     * @throws IOException
     */
    public static List<String> getLines(String fileUri) throws InvalidPathException, IOException {
        return Files.readAllLines(Paths.get(fileUri))
                .parallelStream()
                .filter(line -> !line.isEmpty())
                .collect(toList());
    }

    /**
     * Returns all lines in a file not including empty lines and lines that contain only comments.
     * Pass NO_COMMENT_LINES as second parameter to exclude lines that only contain comments.
     *
     * @param fileUri
     * @param filterComments
     * @throws InvalidPathException
     * @throws IOException
     */
    public static List<String> getLines(String fileUri , boolean filterComments) throws InvalidPathException, IOException {
        if(filterComments){
            return getLines(fileUri).stream()
                    .sequential()
                    .filter(line -> !line.startsWith("#"))
                    .filter(line -> !line.startsWith("//"))
                    .collect(toList());
        } else {
            return getLines(fileUri);
        }
    }

    /**
     * Returns content of a file, not including empty lines.
     *
     * @param fileUri
     * @return String containing all lines in a file
     * @throws InvalidPathException
     * @throws IOException
     */
    public static String getString(String fileUri) throws InvalidPathException, IOException {
        return getLines(fileUri).stream().collect(Collectors.joining());
    }

    /**
     * Returns content of a file, not including empty lines.
     * The lines might not be in the same order as the file.
     * This method might achieve better performance because of parallel stream being used.
     *
     * @param fileUri
     * @throws InvalidPathException
     * @throws IOException
     */
    public static String getStringParallel(String fileUri) throws InvalidPathException, IOException {
        return getLines(fileUri).parallelStream().collect(Collectors.joining());
    }
}
