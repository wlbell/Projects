
    function [h,w] = freq_response(num,den,n)

    % freq_response - computes complex frequency response of digital filter
    %
    % by William Bell 4/30/2017
    
    % USAGE
    %
    % [h,w] = freq_response(num,den,n) returns the n-point complex frequency response
    %         vector, h, calculated at the angular frequencies w from 0 to pi.
    %         Numerator and denominator z-transform coefficients are in num and den.
    %         num and den must have same number of coefficients.
    %  -----------------------------------------------------------------------------------
    
    % make sure num and den are row vectors
    % and get number of terms in polynomial
        
    s = size(num);
    if (s(1) ~= 1), num = num'; end
        
    s = size(den);
    if (s(1) ~= 1), den = den'; end
            
    s = size(num); 
    k = s(2);    
        
    % get freq-sampling vector on unit circle, end exactly on pi
    wstart = 0;
    wend =  pi;
    
    range = wend - wstart;
    freqs = wstart + (range/(n-1))*(0:n-1);
    ejw = exp(j.*freqs);
            
    % evalute numerator and denominator at n-points, p-coefficients
    Numer = zeros(1,n);
    Denom = zeros(1,n);
    p = (0:k-1);
    
    for i = 1:n
        ejw_vec = ejw(i).^-p;
        Numer(i) = sum(num.*ejw_vec);
        Denom(i) = sum(den.*ejw_vec);
    end
    
    % Get Numer/Denom
    
    h = Numer./Denom;
    w = freqs;
    
    