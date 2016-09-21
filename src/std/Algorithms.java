/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package std;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import std.IIterator.IInputIterator;
import std.IIterator.IOutputIterator;

/**
 *
 * @author sergey
 */
public class Algorithms {
    public static <_T1>
    IInputIterator<_T1> find(
            IInputIterator<_T1> first,
            IInputIterator<_T1> end,
            _T1 val)
    {
        while (first.not_equal(end)) {
            if (first.deref_and_get().equals(val)) return first;
            first.inc();
        }
        return end;
    }
    
    public static <_T1>
    IInputIterator<_T1> find_if(
            IInputIterator<_T1> first,
            IInputIterator<_T1> end,
            Predicate<_T1> unaryPredicate)
    {
        while (first.not_equal(end)) {
            if (unaryPredicate.test(first.deref_and_get())) return first;
            first.inc();
        }
        return end;
    }
    
    public static <_T1>
    Consumer<_T1> for_each(
            IInputIterator<_T1> first,
            IInputIterator<_T1> end,
            Consumer<_T1> function)
    {
        while (first.not_equal(end)) {
            function.accept(first.deref_and_get());
            first.inc();
        }
        return function;
    }
    
    public static <_T1, _T2>
    IOutputIterator<_T2> transform(
            IInputIterator<_T1> first1,
            IInputIterator<_T1> last1,
            IOutputIterator<_T2> result,
            Function<_T1, _T2> op)
    {
        while (first1.not_equal(last1)) {
            result.deref_and_set(op.apply(first1.deref_and_get()));
            result.inc();
            first1.inc();
        }
        return result;
    }
    
    public static <_T1, _T2, _T3>
    IOutputIterator<_T3> transform(
            IInputIterator<_T1> first1,
            IInputIterator<_T1> last1,
            IInputIterator<_T2> first2,
            IOutputIterator<_T3> result,
            BiFunction<_T1, _T2, _T3> op)
    {
        while (first1.not_equal(last1)) {
            result.deref_and_set(op.apply(first1.deref_and_get(), first2.deref_and_get()));
            result.inc();
            first1.inc();
            first2.inc();
        }
        return result;
    }
}
