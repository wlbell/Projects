
    % main procedure - compute freq response and plot

    num = [1 2 1];
    den = [1 -.5 .25];
    n = 256;

    [h1 w1] = freq_response(num, den, n);
   
    figure;
    % Plot Magnitude
    plot(w1/pi, abs(h1));
    xlim([w1(1) w1(length(w1))]/pi);
    title('Problem #1  Magnitude');
    ylabel('Magnitude: abs(H(z=ejw))');
    xlabel('Normalized Frequency (x pi rad/point)');
    grid on;
    
    figure;
    % Plot Phase
    plot(w1/pi, 180/pi*angle(h1));
    xlim([w1(1) w1(length(w1))]/pi);
    title('Problem #1 Phase');
    ylabel('Phase (Degrees)');
    xlabel('Normalized Frequency (x pi rad/point)');
    grid on;
    
    %  ------------------------------------------------
    
    num = [1 -1 1];
    den = [1 -0.9  0.81];
    n = 256;
 
    [h2 w2] = freq_response(num, den, n);
    
    figure;
    % Plot Magnitude
    plot(w2/pi, abs(h2));
    xlim([w2(1) w2(length(w2))]/pi);
    title('Problem #2  Magnitude');
    ylabel('Magnitude: abs(H(z=ejw))');
    xlabel('Normalized Frequency (x pi rad/point)');
    grid on;
    
    figure;
    % Plot Phase
    plot(w2/pi, 180/pi*angle(h2));
    xlim([w2(1) w2(length(w2))]/pi);
    title('Problem #2  Phase');
    ylabel('Phase (Degrees)');
    xlabel('Normalized Frequency (x pi rad/point)');
    grid on;