import sqlalchemy


headers = {
    'Access-Control-Allow-Origin': '*'
}

cache_headers = {
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Methods': 'GET',
    'Access-Control-Allow-Headers': 'Content-Type',
    'Access-Control-Max-Age': '3600'
}


def main(request):
    if request.method == 'OPTIONS':
        return '', 204, cache_headers

    keys = ', '.join(map(str, request.get_json()))
    values = ', '.join(map(str, request.get_json().values()))
    insert_query = sqlalchemy.text(f'insert into lab2.measurements ({keys}) values ({values})')
    db = sqlalchemy.create_engine('mysql+pymysql://root:root@10.1.64.3:3306/lab2?unix_socket=/cloudsql/coastal-well-341808:us-central1:lab-2',
                                  pool_size=5,
                                  max_overflow=2,
                                  pool_timeout=30,
                                  pool_recycle=1800)

    try:
        with db.connect() as conn:
            conn.execute(insert_query)
            return 'Success', 201, headers
    except Exception as e:
        return f'Error: {e}', 500, headers
