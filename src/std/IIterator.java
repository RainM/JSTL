/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package std;

/**
 *
 * @author sergey
 * @param <_T1>
 */
public interface IIterator<_T1> {
    public IIterator<_T1> inc();
    public IIterator<_T1> prefix_inc();
    public IIterator<_T1> postfix_inc();
    public void assign(IIterator<_T1> it);
    public IIterator<_T1> copy();
    
    public static interface IInputIterator <_T1> extends IIterator<_T1> {
        public <_T2> boolean equal(IInputIterator<_T2> tt);
        public <_T2> boolean not_equal(IInputIterator<_T2> tt);
        
        public _T1 deref_and_get();
    }
    
    public static interface IOutputIterator<_T1> extends IIterator<_T1> {
        public void deref_and_set(_T1 tt);
        public IOutputIterator<_T1> assign_and_inc(_T1 tt);
    }
    
    public static interface IForwardIterator<_T1> extends IOutputIterator<_T1>, IInputIterator<_T1> {
        
    }
    
    public static interface IBidirectionalInterator<_T1> extends IForwardIterator<_T1> {
        public IBidirectionalInterator<_T1> dec();
        public IBidirectionalInterator<_T1> prefix_dec();
        public IBidirectionalInterator<_T1> postfix_dec();
        public IBidirectionalInterator<_T1> assign_and_dec(_T1 t);
    }
    
    public static interface IRandomAccessIterator<_T1> extends IBidirectionalInterator<_T1> {
        public IRandomAccessIterator<_T1> add(IRandomAccessIterator<_T1> it);
        public IRandomAccessIterator<_T1> sub(IRandomAccessIterator<_T1> it);
        public boolean greater(IRandomAccessIterator<_T1> it);
        public boolean less(IRandomAccessIterator<_T1> it);
        public boolean greater_or_equal(IRandomAccessIterator<_T1> it);
        public boolean less_or_equal(IRandomAccessIterator<_T1> it);
        public IRandomAccessIterator<_T1> add(int i);
        public IRandomAccessIterator<_T1> sub(int i);
        public _T1 at(int i);
   }
}
