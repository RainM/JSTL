/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package std;

/**
 *
 * @author sergey
 */
public interface IContainer<T> {
    public IIterator<T> begin();
    public IIterator<T> end();
    public IIterator<T> rbegin();
    public IIterator<T> eend();
    
    public void resize(int i);
    public void reserve(int i);
}
