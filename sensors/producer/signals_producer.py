import datetime
import json
import random
import time
import os
from google.cloud import tasks_v2

os.environ['GOOGLE_APPLICATION_CREDENTIALS'] = 'credentials.json'
client = tasks_v2.CloudTasksClient()
project = 'coastal-well-341808'
location = 'europe-west1'
queue = 'lab-2-queue'
task_name = 'my-unique-task'
task_url = 'https://us-central1-coastal-well-341808.cloudfunctions.net/add_data'
parent = client.queue_path(project, location, queue)


class Data:
    def __init__(self):
        self._data_date = datetime.datetime.utcnow().isoformat(sep=' ', timespec='milliseconds')
        self._data_light = random.randint(0, 15000)
        self._data_velocity = random.randint(0, 200)
        self._data_acceleration = random.randint(-10, 10)

    def __str__(self):
        return json.dumps({
            key[6:]:
                '\'' + data + '\''
                if isinstance(data, str)
                else data
            for key, data
            in self.__dict__.items()
            if key.startswith('_data')
        })

    def task(self):
        return {
            'http_request': {
                'http_method': tasks_v2.HttpMethod.POST,
                'url': task_url,
                'headers': {'Content-type': 'application/json'},
                'body': str(self).encode()
            }
        }


while True:
    response = client.create_task(request={"parent": parent, "task": Data().task()})
    current_delay = random.randint(20, 100) * 0.001
    print(current_delay)
    time.sleep(current_delay)
