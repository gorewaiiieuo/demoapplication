package mg.studio.demoapplication;

/**
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Service extends AppCompatActivity implements Runnable {
    Handler handler = new Handler();
    private int counterActivity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_27);

    }

    public void btnStart(View view) {
        Intent intent = new Intent(this, MyService_27.class);
        startService(intent);
        Log.d(MyService_27.LOG_TAG, "Button start Service pressed");
        handler.post(this);


    }

    public void btnEnd(View view) {
        Intent intent = new Intent(this, MyService_27.class);
        stopService(intent);
    }

    @Override
    public void run() {
        counterActivity++;
        Log.d(MyService_27.LOG_TAG, "Counter Activity "+counterActivity);
        handler.postDelayed(this, 1000);
    }
}
