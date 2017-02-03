package sgcources.part2.task2.program;

import sgcources.part2.task2.program.QuakeEntry;

/**
 * Write a description of interface Filter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Filter
{
    boolean satisfies(QuakeEntry qe);
    String getName();
}
