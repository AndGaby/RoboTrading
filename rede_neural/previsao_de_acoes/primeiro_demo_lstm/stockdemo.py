from keras.layers.core import Dense, Activation, Dropout
from keras.layers.recurrent import LSTM
from keras.models import Sequential
import keras.models as km
import keras as keras
import lstm, time , os #helper libraries

#Step 1 Load Data
X_train, y_train, X_test, y_test = lstm.load_data('itau_fechamento_02-02-2009_06-03-2017.csv', 50, True)

#Step 2 Build Model
model = Sequential()

model.add(LSTM(
    input_dim=1,
    output_dim=50,
    return_sequences=True))
model.add(Dropout(0.2))

model.add(LSTM(
    100,
    return_sequences=False))
model.add(Dropout(0.2))

model.add(Dense(
    output_dim=1))
model.add(Activation('tanh'))

start = time.time()
model.compile(loss='mse', optimizer='rmsprop',metrics=['accuracy'])
print 'compilation time : ', time.time() - start

#implement tensorboard to visualize data
tbCallBack = keras.callbacks.TensorBoard(log_dir='./Graph', histogram_freq=0,
          write_graph=True, write_images=True)
#to run tensorboard use (tensorboard --logdir=Graph/)
#then access localhost:6006

#Step 3 Train the model
model.fit(
    X_train,
    y_train,
    batch_size=512,
    nb_epoch=1,
    validation_split=0.05,
    validation_data=(X_test, y_test),
    callbacks=[tbCallBack])

#Step 4 - evaluates the model
score, acc = model.evaluate(
                        X_test,
                        y_test,
                        batch_size=512)
#km.save_model(model,'/mnt/c/Users/CaiquedosSantosCoelh/Desktop',True)
print '%s: %.2f%% ' % ('Score',score*100)
print '%s: %.2f%% ' % ('Accuracy',acc*100)

#Step 4 - Plot the predictions!
#predictions = lstm.predict_sequences_multiple(model, X_test, 50, 50)
#lstm.plot_results_multiple(predictions, y_test, 50)
#requires h5py
#km.save_model(model,os.path.abspath("primeiro_demo_lstm"))
