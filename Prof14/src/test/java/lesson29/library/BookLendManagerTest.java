package lesson29.library;

import lesson29.BookLendManager;
import lesson29.BookLendManager.BookService;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BookLendManagerTest {
    @Test
    public void normalCheckoutTest()
    {
        // создать заглушку (мок, mock) для интерфейса BookService
        BookService service = Mockito.mock(BookService.class);

        // настройка поведения заглушки
        when(service.inStock(100)).thenReturn(true);

        BookLendManager manager = new BookLendManager(service);
        // пытаемся выдать книгу с ид 100 пользователю с ид 300
        manager.checkout(100, 300);

        // методы BookService вызывались с правильными параметрами
        verify(service).inStock(100);
        verify(service).lend(100, 300);

        // как минимум один раз вызывалась функция
        verify(service, atLeast(1)).inStock(anyInt());
        verify(service, atMost(10)).lend(100, 300);

        // больше никаких взаимодействий с моком не было
        verifyNoMoreInteractions(service);
    }
    @Test
    public void bookIsNotAvailableTest(){
        // настройте мок чтобы он выдавал false на идентификатор 200
        BookService service = Mockito.mock(BookService.class);
        when(service.inStock(200)).thenReturn(false);
        BookLendManager manager = new BookLendManager(service);
        try {
            manager.checkout(200, 300);
        } catch (Exception e) {
            // убедитесь что вылетает исключение нужного типа и с нужным сообщением
            assertThat(e, instanceOf(IllegalStateException.class));
            assertEquals(e.getMessage(), "Book is not available");
        }
        // метод inStock вызывался только один раз
        verify(service, times(1)).inStock(200);
        // метод lend не вызывался
        verify(service, never()).lend(anyInt(), anyInt());
        verifyNoMoreInteractions(service);
    }
}