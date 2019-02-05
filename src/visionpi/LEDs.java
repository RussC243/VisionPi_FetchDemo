package visionpi;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class LEDs {
        final GpioController gpio = GpioFactory.getInstance(); // create gpio controller
        // provision gpio pins as an output pin and turn off
        final GpioPinDigitalOutput pin_01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput pin_02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput pin_03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput pin_04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.LOW);     
        
    public LEDs(){      //constructor
        pin_01.setShutdownOptions(true, PinState.LOW);
    }
    public void setLow(int gpioNum)
    {
        switch (gpioNum)
        {
            case 1:
                pin_01.low();
                break;
            case 2:
                pin_02.low();
                break;
            case 3:
                pin_03.low();
                break;
            case 4:
                pin_04.low();
                break;
            default:
                System.out.printf("LEDs class has not implemented setLow for gpio %d\n", gpioNum);
                break;
        }
    }
    public void setHigh(int gpioNum)
    {
        switch (gpioNum)
        {
            case 1:
                pin_01.high();
                break;
            case 2:
                pin_02.high();
                break;
            case 3:
                pin_03.high();
                break;
            case 4:
                pin_04.high();
                break;
            default:
                System.out.printf("LEDs class has not implemented setHigh for gpio %d\n", gpioNum);
                break;
        }
    }
    public void toggle(int gpioNum)
    {
        switch (gpioNum)
        {
            case 1:
                pin_01.toggle();
                break;
            case 2:
                pin_02.toggle();
                break;
            case 3:
                pin_03.toggle();
                break;
            case 4:
                pin_04.toggle();
                break;
            default:
                System.out.printf("LEDs class has not implemented toggle for gpio %d\n", gpioNum);
                break;
        }
    }        
    public void singleOn(int ledNum){
        pin_01.low();
        pin_02.low();
        pin_03.low();
        pin_04.low();
        switch (ledNum)
        {
            case 1:
                pin_01.high();
                break;
            case 2:
                pin_02.high();
                break;
            case 3:
                pin_03.high();
                break;
            case 4:
                pin_04.high();
                break;
            default:
                System.out.printf("LEDs class has not implemented test for gpio %d\n", ledNum);
                break;
        }
    }
}
