import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("E-Commerce App");

        // Initialize RecyclerView and ProductAdapter
        productRecyclerView = findViewById(R.id.productRecyclerView);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(this, productList);
        productRecyclerView.setAdapter(productAdapter);

        // Sample data (replace with your own data from API or database)
        addSampleData();
    }

    // Method to add sample product data to the list
    private void addSampleData() {
        productList.add(new Product("Product 1", "Description 1", "Price 100"));
        productList.add(new Product("Product 2", "Description 2", "Price 200"));
        productList.add(new Product("Product 3", "Description 3", "Price 300"));
        // Add more products as needed
        productAdapter.notifyDataSetChanged();
    }
}
