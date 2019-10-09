# ImageSlider

![alt text](https://media.giphy.com/media/MAoLAE5s5ipxAykdr2/giphy.gif)


## There're few Steps to use this library

### Step One: Add the dependency

```
     allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```
     implementation 'com.github.Nadaaaa:ImageSlider:1.0.0'
```

### Step two: Add the XML Code
```
<com.nada.imageslider.ImageSlider
        android:id="@+id/imageSlider"
        android:layout_width="match_parent"
        android:layout_height="300dp"/>
```

### Step Three: Add adapter
```
public class SliderAdapter extends ImageSliderAdapter<SliderAdapter.SliderAdapterViewHolder> {

    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        return new SliderAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_image, null));
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {

        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView)
                        .load("https://picsum.photos/id/10/1500/1000")
                        .into(viewHolder.imageView);
                break;
            case 1:
                Glide.with(viewHolder.itemView)
                        .load("https://picsum.photos/id/1021/1500/1000")
                        .into(viewHolder.imageView);
                break;
            case 2:
                Glide.with(viewHolder.itemView)
                        .load("https://picsum.photos/id/1002/1500/1000")
                        .into(viewHolder.imageView);
                break;
            default:
                Glide.with(viewHolder.itemView)
                        .load("https://picsum.photos/id/1000/1500/1000")
                        .into(viewHolder.imageView);
                break;

        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    class SliderAdapterViewHolder extends ImageSliderAdapter.ViewHolder {
        ImageView imageView;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
```
### Step Four: Call it in the Activity
```
public class MainActivity extends AppCompatActivity {

    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider = findViewById(R.id.imageSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(getApplicationContext());

        imageSlider.setSliderAdapter(sliderAdapter);
        imageSlider.createSlideShow();

    }
}
```
