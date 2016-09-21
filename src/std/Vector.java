/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package std;

import java.util.ArrayList;
import std.IIterator.IRandomAccessIterator;

/**
 *
 * @author sergey
 */
public class Vector <_T1> implements IContainer<_T1> {

    private ArrayList<_T1> _j_impl = new ArrayList<>();

    @Override
    public void resize(int new_size) {
        for (int i = _j_impl.size(); i < new_size; ++i) {
            _j_impl.add(null);
        }
    }

    @Override
    public void reserve(int i) {
        
    }
    
    public _T1 at(int i) {
        return _j_impl.get(i);
    }
    
    public void at(int i, _T1 t) {
        _j_impl.set(i, t);
    }
    
    private static class VectorRAIterator<_T1> implements IRandomAccessIterator<_T1> {

        private Vector<_T1> _parent_vector;
        private int _idx;
        
        public VectorRAIterator(Vector v, int idx) {
            _parent_vector = v;
            _idx = idx;
        }
        
        @Override
        public void assign(IIterator<_T1> it) {
            
        }
        
        @Override
        public IRandomAccessIterator<_T1> add(IRandomAccessIterator<_T1> it) {
            VectorRAIterator<_T1> it_ = (VectorRAIterator<_T1>) it;
            assert _parent_vector == it_._parent_vector;
            
            _idx += it_._idx;
            
            return this;
        }

        @Override
        public IRandomAccessIterator<_T1> sub(IRandomAccessIterator<_T1> it) {
            VectorRAIterator<_T1> it_ = (VectorRAIterator<_T1>) it;
            assert _parent_vector == it_._parent_vector;
            
            _idx -= it_._idx;
            
            return this;
        }

        @Override
        public boolean greater(IRandomAccessIterator<_T1> it) {
            VectorRAIterator<_T1> it_ = (VectorRAIterator<_T1>) it;
            assert _parent_vector == it_._parent_vector;
            
            return _idx > it_._idx;
        }

        @Override
        public boolean less(IRandomAccessIterator<_T1> it) {
            VectorRAIterator<_T1> it_ = (VectorRAIterator<_T1>) it;
            assert _parent_vector == it_._parent_vector;
            
            return _idx < it_._idx;
        }

        @Override
        public boolean greater_or_equal(IRandomAccessIterator<_T1> it) {
            VectorRAIterator<_T1> it_ = (VectorRAIterator<_T1>) it;
            assert _parent_vector == it_._parent_vector;
            
            return _idx >= it_._idx;
        }

        @Override
        public boolean less_or_equal(IRandomAccessIterator<_T1> it) {
            VectorRAIterator<_T1> it_ = (VectorRAIterator<_T1>) it;
            assert _parent_vector == it_._parent_vector;
            
            return _idx <= it_._idx;
        }

        @Override
        public IRandomAccessIterator<_T1> add(int i) {
            _idx += i;
            return this;
        }

        @Override
        public IRandomAccessIterator<_T1> sub(int i) {
            _idx -= i;
            return this;
        }

        @Override
        public _T1 at(int i) {
            return _parent_vector._j_impl.get(i);
        }

        @Override
        public IBidirectionalInterator<_T1> dec() {
            _idx -= 1;
            return this;
        }

        @Override
        public IBidirectionalInterator<_T1> prefix_dec() {
            _idx -= 1;
            return this;
        }

        @Override
        public IBidirectionalInterator<_T1> postfix_dec() {
            IBidirectionalInterator<_T1> result = (IBidirectionalInterator<_T1>)copy();
            
            _idx -= 1;
            
            return result;
        }

        @Override
        public IBidirectionalInterator<_T1> assign_and_dec(_T1 t) {
            _parent_vector._j_impl.set(_idx, t);
            _idx -= 1;
            return this;
        }

        @Override
        public void deref_and_set(_T1 tt) {
            _parent_vector._j_impl.set(_idx, tt);
        }

        @Override
        public IOutputIterator<_T1> assign_and_inc(_T1 tt) {
            _parent_vector._j_impl.set(_idx, tt);
            _idx += 1;
            return this;
        }

        @Override
        public IIterator<_T1> inc() {
            _idx += 1;
            return this;
        }

        @Override
        public IIterator<_T1> prefix_inc() {
            return inc();
        }

        @Override
        public IIterator<_T1> postfix_inc() {
            IIterator<_T1> result = copy();
            _idx += 1;
            
            return result;
        }

        @Override
        public <_T2> boolean equal(IInputIterator<_T2> it) {
            VectorRAIterator<_T1> it_ = (VectorRAIterator<_T1>) it;
            assert _parent_vector == it_._parent_vector;
            
            return _idx == it_._idx;
        }

        @Override
        public <_T2> boolean not_equal(IInputIterator<_T2> it) {
            VectorRAIterator<_T1> it_ = (VectorRAIterator<_T1>) it;
            assert _parent_vector == it_._parent_vector;
            
            return _idx != it_._idx;
        }

        @Override
        public _T1 deref_and_get() {
            return _parent_vector._j_impl.get(_idx);
        }

        @Override
        public IIterator<_T1> copy() {
            return new VectorRAIterator(_parent_vector, _idx);
        }
    }
    
    @Override
    public IRandomAccessIterator<_T1> begin() {
        return new VectorRAIterator(this, 0);
    }

    @Override
    public IRandomAccessIterator<_T1> end() {
        return new VectorRAIterator(this, _j_impl.size());
    }

    @Override
    public IRandomAccessIterator<_T1> rbegin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IRandomAccessIterator<_T1> eend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
